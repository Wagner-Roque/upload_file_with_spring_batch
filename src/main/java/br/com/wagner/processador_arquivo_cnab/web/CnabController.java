package br.com.wagner.processador_arquivo_cnab.web;

import br.com.wagner.processador_arquivo_cnab.service.CnabService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cnab")
public class CnabController {

    private final CnabService cnabService;

    public CnabController(CnabService cnabService) {
        this.cnabService = cnabService;
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        cnabService.uploadCnabFile(file);
        return "Start process!";
    }
}
