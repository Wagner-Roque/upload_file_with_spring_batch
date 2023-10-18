package br.com.wagner.processador_arquivo_cnab.record;

import java.math.BigDecimal;

public record TransactionCNAB(Integer type, String data, BigDecimal valor, Long cpf, String card,
                            String time, String storeOwner, String storeName) {
}
