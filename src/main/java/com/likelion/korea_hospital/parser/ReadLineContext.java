package com.likelion.korea_hospital.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext<T> {

    private Parser<T> parser;
    private boolean isRemoveColumnName = true;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    public List<T> readByLine(String filename) throws IOException {

        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"utf-8"));
        String str;

        if (isRemoveColumnName) {
            reader.readLine();
        }

        while ((str = reader.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.printf("파싱중 문제가 생겨 해당 줄을 넘어갑니다. %s \n", str.substring(0,10));
            }
        }
        reader.close();
        return result;
    }
}

