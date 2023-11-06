enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Classe para representar ConteudosEducacionais
data class ConteudoEducacional(val nome: String, val descricao: String)

// Classe para representar Formacoes
data class Formacao(val nome: String,val nivel:Nivel, val conteudos: List<ConteudoEducacional>)

// Classe para representar Alunos
data class Aluno(val nome: String)

// Classe para representar a DIO (Digital Innovation One)
class DIO {
    private val formacoes = mutableListOf<Formacao>()
    private val alunos = mutableListOf<Aluno>()

    // Método para adicionar uma formação à DIO
    fun adicionarFormacao(formacao: Formacao) {
        formacoes.add(formacao)
    }

    // Método para matricular um aluno em uma formação
    fun matricularAluno(aluno: Aluno, formacao: Formacao) {
        if (alunos.contains(aluno)) {
            // Verifica se o aluno já está matriculado
            println("${aluno.nome} já está matriculado na formação ${formacao.nome}.")
        } else if (!formacoes.contains(formacao)) {
            // Verifica se a formação existe
            println("A formação ${formacao.nome} não está disponível.")
        } else {
            // Matricula o aluno na formação
            alunos.add(aluno)
            println("${aluno.nome} foi matriculado na formação ${formacao.nome}.")
        }
    }

    // Método para listar todas as formações disponíveis
    fun listarFormacoesDisponiveis() {
        for (formacao in formacoes) {
            println("Formação: ${formacao.nome}, Nível: ${formacao.nivel}")
        }
    }
}

fun main() {
    val dio = DIO()

    // Criando alguns ConteudosEducacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", "Fundamentos de programação")
    val conteudo2 = ConteudoEducacional("Desenvolvimento Web", "Construção de sites e aplicativos web")
    val conteudo3 = ConteudoEducacional("Banco de Dados", "Gerenciamento de dados")
    val conteudo4 = ConteudoEducacional("Desenvolvimento Mobile", "Desenvolvimento de aplicativos móveis")
    val conteudo5 = ConteudoEducacional("Desenvolvimento de APIs", "Desenvolvimento de APIs REST e SOAP")

    // Criando algumas Formacoes
    val formacao1 = Formacao("Desenvolvedor Web", Nivel.BASICO, listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Analista de Dados", Nivel.DIFICIL, listOf(conteudo1, conteudo3))
    val formacao3 = Formacao("Desenvolvedor Mobile", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo4))
    val formacao4 = Formacao("Desenvolvedor de APIs", Nivel.DIFICIL, listOf(conteudo1, conteudo5))

    // Adicionando as formações à DIO
    dio.adicionarFormacao(formacao1)
    dio.adicionarFormacao(formacao2)
    dio.adicionarFormacao(formacao3)
    dio.adicionarFormacao(formacao4)

    // Criando alguns alunos
    val aluno1 = Aluno("Giancarlo")
    val aluno2 = Aluno("Yanna")
    val aluno3 = Aluno("Rodrigo")
    val aluno4 = Aluno("Leticia")

    // Matriculando alunos em formações
    dio.matricularAluno(aluno1, formacao1)
    dio.matricularAluno(aluno2, formacao1)
    dio.matricularAluno(aluno1, formacao2)
    dio.matricularAluno(aluno3, formacao4)
    dio.matricularAluno(aluno4, formacao3)

    // Listando formações disponíveis
    dio.listarFormacoesDisponiveis()
}
