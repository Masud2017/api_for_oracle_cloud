package com.apiproject.openapi.controllers;

import com.apiproject.openapi.models.AudioItem;
import com.apiproject.openapi.services.AudioResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Api(value = "audio-resource-controller", description = "Controlls all the audio item resouce related data and operations", tags = { "AudioItem resource"})
@RestController
@RequestMapping(value = "/api/v1",method = RequestMethod.GET)
public class AudioResourceController {
    @Autowired
    private AudioResourceService audioResourceService;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "developer", value = "Sahil Santosh Bhagat - 40216558", dataType = "string", 
                          paramType = "header")
    })
    
    @GetMapping(value = "/audioitemlist")
    public ResponseEntity<List<AudioItem>> getAudioItemList() {
        return ResponseEntity.ok(this.audioResourceService.getAudioItemList());
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "developer", value = "Sahil Santosh Bhagat - 40216558", dataType = "string", 
                          paramType = "header")
    })
    
    @GetMapping(value = "/audioitem/{audioitemid}")
    public ResponseEntity<AudioItem> getAudioItemById(@PathVariable Double audioitemid) {
        return ResponseEntity.ok(this.audioResourceService.getAudioItemById(audioitemid));
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "developer", value = "Sahil Santosh Bhagat - 40216558", dataType = "string", 
                          paramType = "header")
    })
    
    @GetMapping(value = "/audioitemname/{artistname}")
    public ResponseEntity<AudioItem> getAudioItemByArtistsName(@PathVariable String artistname) {
        return ResponseEntity.ok(this.audioResourceService.getAudioItemByArtistsName(artistname));
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "developer", value = "Adnaan khan 40185329", dataType = "string", 
                          paramType = "header")
    })
    
    @PostMapping(value ="/setaudioitem")
    public ResponseEntity<Map<String,Integer>> addNewAduioItem(@RequestBody AudioItem audioItem, HttpServletRequest req) {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            return ResponseEntity.ok(this.audioResourceService.addNewAudioItemToDB(audioItem));
        }
        Map<String,Integer> map = new HashMap<>();
        map.put("status",405);
        return ResponseEntity.ok(map);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "developer", value = "Adnaan khan 40185329", dataType = "string", 
                        paramType = "header")
    })
    @GetMapping(value= "/totalCopiesSold")
    public ResponseEntity<Map<String,Integer>> getTotalCopiesSold() {
        Map<String,Integer> map = new HashMap<>();
        map.put("totalCopiesSold",this.audioResourceService.getTotalCopiesSold());
        
        return ResponseEntity.ok(map);
    }
}
