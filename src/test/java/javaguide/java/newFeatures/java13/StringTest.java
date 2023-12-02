package javaguide.java.newFeatures.java13;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void oldHtml() {
        String json = "{\n" +
                "   \"name\":\"mkyong\",\n" +
                "   \"age\":38\n" +
                "}\n";
        System.out.println(json);
    }
    /*
    {
       "name":"mkyong",
       "age":38
    }
     */

    @Test
    public void newHtml() {
        String json = """
                {
                    "name":"mkyong",
                    "age":38
                }
                """;
        System.out.println(json);
    }
    /*
    {
        "name":"mkyong",
        "age":38
    }
     */

    @Test
    public void oldSql() {
        String query = "SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`\n" +
                "WHERE `CITY` = 'INDIANAPOLIS'\n" +
                "ORDER BY `EMP_ID`, `LAST_NAME`;\n";
        System.out.println(query);
    }
    /*
    SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
    WHERE `CITY` = 'INDIANAPOLIS'
    ORDER BY `EMP_ID`, `LAST_NAME`;
     */

    @Test
    public void newSql() {
        String query = """
               SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
               WHERE `CITY` = 'INDIANAPOLIS'
               ORDER BY `EMP_ID`, `LAST_NAME`;
               """;
        System.out.println(query);
    }
    /*
    SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
    WHERE `CITY` = 'INDIANAPOLIS'
    ORDER BY `EMP_ID`, `LAST_NAME`;
     */
}
