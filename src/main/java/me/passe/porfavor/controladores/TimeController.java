package me.passe.porfavor.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.passe.porfavor.entidades.Times;
import me.passe.porfavor.repositorios.TimeRepositorio;

@Controller
public class TimeController {
	@Autowired
	private TimeRepositorio timeRepositorio;
	
	@RequestMapping(value = "/")
	public String listarTimes(Model model) {
		model.addAttribute("times", timeRepositorio.findAll());
		return "pagina";
	}
	
		@RequestMapping(value = "/pagina/save")
		public String salvar(Times times ) {
			timeRepositorio.save(times);
			return "redirect:/";
		}
		@RequestMapping("/resultado")
		public String goTimeResultado(Model model){
			model.addAttribute("Times", timeRepositorio.findAll());
			return "Resultado";
		}
		
}



