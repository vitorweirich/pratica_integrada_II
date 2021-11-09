package edu.com.unoesc.restaurante.controllers;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.FuncionarioDAO;
import edu.com.unoesc.restaurante.form.FuncionarioAdicionarForm;
import edu.com.unoesc.restaurante.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;
    @Autowired
    private EnderecoDAO enderecoDAO;
    @Autowired
    private EstabelecimentoDAO estabelecimentoDAO;

    @GetMapping(value = "/funcionarios")
    public String funcionariosList(Model m) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>(funcionarioDAO.getFuncionarios());

        m.addAttribute("listFuncionarios", funcionarios);
        m.addAttribute("funcionarioForm", new FuncionarioAdicionarForm());

        return "funcionario";
    }

    @PostMapping(value = "/funcionarioSave")
    public String save(@Valid @ModelAttribute("funcionarioForm") FuncionarioAdicionarForm funcionarioForm, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/funcionarios";
        }

        Funcionario funcionario = funcionarioForm.getFuncionario(enderecoDAO, estabelecimentoDAO);
        if (funcionario.getId() == -1) {
            funcionarioDAO.insertFuncionario(funcionario);
        } else {
            funcionarioDAO.updateFuncionario(funcionario);
        }

        return "redirect:/funcionarios";
    }

    @RequestMapping(value = "/funcionario/{id}")
    public String funcionarioEditar(@PathVariable int id, Model model, HttpSession session) {

        model.addAttribute("listFuncionarios", funcionarioDAO.getFuncionarios());
        model.addAttribute("funcionario", funcionarioDAO.getFuncionarioById(id));

        return "funcionario";
    }

    @GetMapping(value = "/funcionario/{id}/deletar")
    public String funcionarioDeletar(@PathVariable int id, Model model, HttpSession session) {
        funcionarioDAO.deleteFuncionario(id);
        return "redirect:/funcionarios";
    }
}
