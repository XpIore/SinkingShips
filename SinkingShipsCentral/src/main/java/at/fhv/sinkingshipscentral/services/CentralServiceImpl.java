package at.fhv.sinkingshipscentral.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SinkingShips")
public class CentralServiceImpl {

    @Autowired
    private CentralService centralService;


}
