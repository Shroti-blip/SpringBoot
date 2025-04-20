package com.shroti.personClass.Cricket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/showallcricketers")
public class ReadController {
    @Autowired
    CricketRepo cricketRepo ;
    @GetMapping()
    @ResponseBody
    public Iterable<CricketEntity> getData(){
        return cricketRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CricketEntity> getbyId(@PathVariable int id){
        return cricketRepo.findById(id)// select *from cricketer where id=xyz;
                .map(ResponseEntity::ok)//if
                .orElse(ResponseEntity.notFound().build());//else
    }

    @GetMapping("/byname/{name}")
    @ResponseBody
    public List<CricketEntity> getByName(@PathVariable String name){
    return cricketRepo.getByName(name);

    }

    @GetMapping("/byteam/{team}")
    @ResponseBody
    public List<CricketEntity> getBYTeam(@PathVariable String team){
        return cricketRepo.getByTeam(team);
    }
}
