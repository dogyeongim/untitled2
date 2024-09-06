package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/cooks")
@Transactional
public class CookController {

    @Autowired
    CookRepository cookRepository;

    @RequestMapping(
        value = "/cooks/{id}//isaccept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook isAccept(
        @PathVariable(value = "id") Long id,
        @RequestBody IsAcceptCommand isAcceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/isAccept  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.isAccept(isAcceptCommand);

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "/cooks/{id}//startcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook startCook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/startCook  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.startCook();

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "/cooks/{id}//completecook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook completeCook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/completeCook  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.completeCook();

        cookRepository.save(cook);
        return cook;
    }
}
//>>> Clean Arch / Inbound Adaptor
