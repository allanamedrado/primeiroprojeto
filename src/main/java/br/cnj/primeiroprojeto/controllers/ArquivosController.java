package br.cnj.primeiroprojeto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/arquivos")
public class ArquivosController {
    private static final String DIR_UPLOAD = "uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) return new ResponseEntity<>("Selecione um arquivo pra fazer upload", HttpStatus.BAD_REQUEST);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(DIR_UPLOAD + file.getOriginalFilename(), null);
            Files.write(path, bytes);

            return new ResponseEntity<>("Arquivo salvo com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
