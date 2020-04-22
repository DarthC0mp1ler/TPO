package Implementation;

import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HtmlBuilder {

    public static String getHtmlResponce(String s){
        //tekisuto
        String テキスト = "";
        try {
            File file = new File("C:\\Users\\Asus\\Desktop\\Assignment03\\src\\Resources\\Response.html");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(line.trim().equals("<!---->")){
                    テキスト+=s;
                }else{
                    テキスト+=line;
                }
                テキスト+="\n";
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return テキスト;
    }


}
