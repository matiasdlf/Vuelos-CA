package ar.edu.undec.prog.Service.Controller;

import ar.edu.undec.prog.Service.ServiceMapper.TipoPilotoDTOMapper;
import ar.edu.undec.prog.Service.ModeloService.TipoPilotoDTO;
import input.IBuscarTipoPilotosPorDenominacionInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class BuscarTipoPilotosPorDenominacionController {

    private IBuscarTipoPilotosPorDenominacionInput buscarTipoPilotosPorDenominacionInput;

    public BuscarTipoPilotosPorDenominacionController(IBuscarTipoPilotosPorDenominacionInput buscarTipoPilotosPorDenominacionInput) {
        this.buscarTipoPilotosPorDenominacionInput = buscarTipoPilotosPorDenominacionInput;
    }

    @RequestMapping(value = "tipoPiloto/denominacion/{denominacion}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> consultarAccionPorNombre(@PathVariable("denominacion") String denominacion){
        try {
            List<TipoPilotoDTO> tiposPiloto = new ArrayList<>();
            this.buscarTipoPilotosPorDenominacionInput.buscarTipoPilotosPorDenominacion(denominacion).forEach(tp -> tiposPiloto.add(new TipoPilotoDTOMapper().mapeoCoreDTO(tp)));;
            if (tiposPiloto.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tiposPiloto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
