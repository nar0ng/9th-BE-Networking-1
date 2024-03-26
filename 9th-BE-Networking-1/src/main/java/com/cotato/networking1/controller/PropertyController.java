package com.cotato.networking1.controller;

import com.cotato.networking1.domain.Property;
import com.cotato.networking1.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PropertyController {
    private PropertyService propertyService;

    @PostMapping("/test-data")
    public ResponseEntity<?> uploadPropertiesData(@RequestParam("file")MultipartFile file){
        propertyService.savePropertiesToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message", "Properties data uploaded and saved to database successfully"));
    }

    @GetMapping
    public ResponseEntity<List<Property>> getProperties(){
        return new ResponseEntity<>(propertyService.getProperties(), HttpStatus.FOUND);
    }
}