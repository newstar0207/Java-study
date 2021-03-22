package ch12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TextConverter2 extends JFrame implements ActionListener {
    private JButton convertBtn;
    private JButton cancelBtn;
    private JTextArea textIn;
    private JTextArea textOut;
    private final String CLIENT_ID = "";
    private final String CLIENT_SECRET = "";
    
    // String �� ���� �ϳ��ϳ� ������ �ϴ� �� -> s.charAt(i);
    // int idx = s.indexOf("��λ�") - > ��λ��� ���۵Ǵ� �ε��� ��ȣ
    
    public TextConverter2() {
        super("�ؽ�Ʈ ��ȯ");

        textIn = new JTextArea(10, 14);
        textOut = new JTextArea(10, 14);
        textIn.setLineWrap(true);
        textOut.setLineWrap(true);
        textOut.setEditable(false);

        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);

        convertBtn = new JButton("��ȯ");
        cancelBtn = new JButton("���");
        convertBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.add(convertBtn);
        btnPanel.add(cancelBtn);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertBtn) {
            textOut.setText("");
            String result = toEnglish(textIn.getText());  // result -> ������ �����
            result = JsonParser(result);
            textOut.append(result);
        }

        if (e.getSource() == cancelBtn) {
            textOut.setText("");
        }
    }
    
    public String JsonParser(String result) {
    	JsonParser parser = new JsonParser();
    	JsonElement element = parser.parse(result);
    	if(element.getAsJsonObject().get("errorMessage") != null) {
    		String transResult = ("errorcode : " + element.getAsJsonObject().get("errorCode").getAsString());
    		return transResult;
    	}else if(element.getAsJsonObject().get("message") != null) {
    		String transResult = (element.getAsJsonObject().get("message").getAsJsonObject().get("result")
    		.getAsJsonObject().get("translatedText").getAsString());
    		return transResult;
    	}else {
    		return "error";
    	}
    }
    
    
/////////�����߰��Ѱ�
    private String toEnglish(String korean) { // textIn �� �ؽ�Ʈ�� korean ���� ����
        String result = korean;

        // result = result.replace("�ؽ�Ʈ", "text");
        // result = result.replace("����", "english");
        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        String text;
        try {
            text = URLEncoder.encode(korean, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("���ڵ� ����", e);
        }

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

        result = post(apiURL, requestHeaders, text);
//        result = result.substring(result.indexOf("translatedText") + "translatedText".length() + 3, result.indexOf("engineType") -3); // substring �� �̿��Ͽ� ������ ���常 ������ / ������ �ٲ��� ����
        return result;
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; //�������: �ѱ��� (ko) -> �������: ���� (en)
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ����
                return readBody(con.getInputStream());
            } else {  // ���� ����
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ��û�� ���� ����", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
        }
    }

    public static void main(String[] args) {
        new TextConverter2();
    }

}
