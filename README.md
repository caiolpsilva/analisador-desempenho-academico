# Analisador de Desempenho Acadêmico

O Analisador de Desempenho Acadêmico é uma aplicação console em Java que simula um sistema simples para análise do desempenho de um único aluno. Ele permite registrar notas, calcular média e desvio padrão, definir status acadêmico ("Aprovado", "Recuperação" ou "Reprovado") e fornecer feedback qualitativo sobre a consistência do desempenho.

## Funcionalidades

- Registro de até 5 notas com validação (valores entre 0.0 e 10.0)
- Cálculo da média aritmética e do desvio padrão
- Classificação automática do status acadêmico:
    - "Aprovado" (média ≥ 7.0)
    - "Recuperação" (5.0 ≤ média < 7.0)
    - "Reprovado" (média < 5.0)
- Feedback qualitativo baseado na variação das notas
- Calculadora científica integrada (raiz quadrada, potência, arredondamento, número aleatório)
- Simulação de logs com horários aleatórios após cada registro

## Conceitos de Java utilizados

- `Scanner` para entrada de dados e `System.out` para saída
- Estruturas condicionais (`if`, `switch`) e de repetição (`for`, `while`)
- Arrays unidimensionais de tamanho fixo
- Métodos estáticos e modularização
- Classe `Math` (`sqrt`, `pow`, `round`, `random`)
- Formatação de strings com `String.format`
- Validação de entrada e boas práticas de legibilidade

## Como executar

**Pré-requisito**: JDK 17 ou superior instalado.

1. Clone ou baixe este repositório.
2. Abra o terminal na pasta raiz do projeto.
3. Compile o arquivo principal:
   ```bash
   javac AnaliseDesempenhoAcademico.java
4. Execute o programa:
   ```bash
   java AnaliseDesempenhoAcademico
