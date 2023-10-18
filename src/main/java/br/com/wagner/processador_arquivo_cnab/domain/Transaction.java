package br.com.wagner.processador_arquivo_cnab.domain;

import java.math.BigDecimal;
import java.sql.Date;
//import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transaction(Long id, Integer type, Date data, BigDecimal valor, Long cpf, String card,
                          Time time, String storeOwner, String storeName) {
    public Transaction withValue(BigDecimal valor){
        return new Transaction(
                this.id, this.type, this.data, valor, this.cpf, this.card, this.time, this.storeOwner, this.storeName
        );
    }
    public Transaction withDate(String data) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var date = dateFormat.parse(data);

        return new Transaction(
                this.id, this.type, new Date(date.getTime()), this.valor, this.cpf, this.card, this.time, this.storeOwner, this.storeName
        );
    }

    public Transaction whithTime(String time) throws ParseException {
        var dateFormat = new SimpleDateFormat("HHmmss");
        var timer = dateFormat.parse(time);

        return new Transaction(
                this.id, this.type, this.data, this.valor, this.cpf, this.card, new Time(timer.getTime()), this.storeOwner, this.storeName
        );
    }
}
