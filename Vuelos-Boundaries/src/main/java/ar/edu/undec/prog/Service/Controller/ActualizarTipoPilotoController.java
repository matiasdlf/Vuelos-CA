package ar.edu.undec.prog.Service.Controller;

import ar.edu.undec.prog.Service.ServiceMapper.TipoPilotoDTOMapper;
import ar.edu.undec.prog.Service.ModeloService.TipoPilotoDTO;
import excepciones.TipoPilotoExisteException;
import input.IActualizarTipoPilotoInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ActualizarTipoPilotoController {

    private IActualizarTipoPilotoInput actualizarTipoPilotoInput;

    public ActualizarTipoPilotoController(IActualizarTipoPilotoInput actualizarTipoPilotoInput) {
        this.actualizarTipoPilotoInput = actualizarTipoPilotoInput;
    }

    @RequestMapping(value = "tipoPiloto", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> actualizarTipoPiloto(@RequestBody TipoPilotoDTO tipoPilotoDTO) {
        try {
            boolean resultado = this.actualizarTipoPilotoInput.actualizarTipoPiloto(new TipoPilotoDTOMapper().mapeoDTOCore(tipoPilotoDTO));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoPilotoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }

}
