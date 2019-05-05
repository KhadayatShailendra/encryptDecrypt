package demo.application.encryptDecrypt.controller;


import demo.application.encryptDecrypt.service.EncryptDecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
public class EncryptDecryptController {

    @Autowired
    private EncryptDecryptService _service;

    @GetMapping(value = "/test")
    public String test(){
        return "Test success";
    }


    @RequestMapping(value = "/Encrypt", method = RequestMethod.GET)
    public ResponseEntity<String> Encrypt(@RequestParam("value") String value){

        if(value==null || value=="")
            return new ResponseEntity<String>("",HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(_service.Encrypt(value), HttpStatus.OK);
    }

    @RequestMapping(value = "/Decrypt", method = RequestMethod.GET)
    public ResponseEntity<String> Decrypt(@RequestParam("value") String value){

        if(value==null || value=="")
            return new ResponseEntity<String>("",HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(_service.Decrypt(value), HttpStatus.OK);
    }

}
