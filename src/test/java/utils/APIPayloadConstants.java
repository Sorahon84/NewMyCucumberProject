package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"asana\",\n" +
                "  \"emp_lastname\": \"lawrance\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1993-01-12\",\n" +
                "  \"emp_status\": \"permanent\",\n" +
                "  \"emp_job_title\": \"QA Manager\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","asana");
        obj.put("emp_lastname","lawrance");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1993-01-12");
        obj.put("emp_status","permanent");
        obj.put("emp_job_title","QA Manager");
        return obj.toString();
    }

    public static String createEmployeeJsonPayloadDynamic(String emp_firstname,
                                                          String emp_lastname,
                                                          String emp_middle_name,
                                                          String emp_gender,
                                                          String emp_birthday,
                                                          String emp_status,
                                                          String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);
        return obj.toString();
    }

    public static String updateEmployeePayload(){
        String updateEmployeePayload = "{\n" +
                "  \"employee_id\": \"113772A\",\n" +
                "  \"emp_firstname\": \"denis\",\n" +
                "  \"emp_lastname\": \"sekar\",\n" +
                "  \"emp_middle_name\": \"msa\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2020-11-07\",\n" +
                "  \"emp_status\": \"probation\",\n" +
                "  \"emp_job_title\": \"trainee\"\n" +
                "}";

        return updateEmployeePayload;
    }

    public static String patchEmployeePayload(){
        String patchEmployeePayload = "{\n" +
                "  \"employee_id\": \"113772A\",\n" +
                "  \"emp_firstname\": \"denis\",\n" +
                "  \"emp_job_title\": \"QA LEAD\"\n" +
                "}";

        return patchEmployeePayload;
    }


}
