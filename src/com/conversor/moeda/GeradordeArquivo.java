package com.conversor.moeda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeradordeArquivo {
    public void salvaJson(List<Moeda> conversoes) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = "conversoes_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".json";
        FileWriter escrita = new FileWriter(fileName);
        escrita.write(gson.toJson(conversoes));
        escrita.close();

    }
}