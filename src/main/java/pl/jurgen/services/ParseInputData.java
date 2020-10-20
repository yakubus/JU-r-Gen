package pl.jurgen.services;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class ParseInputData {


    public static ArrayList<DataModel> parseFields(String input) {
        ArrayList<DataModel> fieldList = new ArrayList<DataModel>();
        int i = 0;
        while (i < input.split(",").length) {
            DataModel field = new DataModel();
            field.part = input.split(",")[i];
            System.out.println("part=" + field.part);
            if (field.part.contains("=[")) {
                while (!field.part.contains("]")) {
                    i++;
                    field.part = field.part + "," + input.split(",")[i];
                    System.out.println("part=" + field.part);
                }
                field.listValue = true;
            }
            field.label = field.part.split("=")[0].trim();
            System.out.println(parseValue(field));
            field.value = parseValue(field);
            fieldList.add(field);
            i++;
        }
        return fieldList;
    }

    private static String parseValue(DataModel field) {
        String result = (field.part.split("=").length > 1) ? field.part.split("=")[1].trim() : StringUtils.EMPTY;
        if (field.listValue) {
            String tmp = new String();
            for (int i = 0; i < result.split(",").length; i++) {
                String separator = (i == 0) ? "\"" : ",\"";
                tmp = tmp + separator + result.split(",")[i].replace('[', Character.MIN_VALUE).replace(']', Character.MIN_VALUE).trim() + "\"";
            }
            result = "Arrays.asList(" + tmp + ")";
            System.out.println("result:" + result);
        }
        return result;
    }


}