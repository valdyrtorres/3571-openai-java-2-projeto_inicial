package br.com.alura.ecomart.chatbot.domain.service;

import br.com.alura.ecomart.chatbot.infra.openai.DadosRequisicaoChatCompletion;
import br.com.alura.ecomart.chatbot.infra.openai.OpenAIClient;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    private OpenAIClient cliente;

    public ChatbotService(OpenAIClient cliente) {
        this.cliente = cliente;
    }

    public String responderPergunta(String pergunta) {
        var promptSistema = "Você é um chatbot de atendimento a clientes de um ecommerce e deve responder apenas perguntas relacionadas com o ecommerce";
        var dados = new DadosRequisicaoChatCompletion(promptSistema, pergunta);
        return cliente.enviarRequisicaoChatCompletion(dados);
    }
}
