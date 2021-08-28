# Projeto que aborda os Princípios S.O.L.I.D
Este projeto tem como objetivo aplicar os conceitos da boa Orientação à Objetos, assim como os princípios S.O.L.I.D de forma simples.


### Princípios da Orientação à Objetos
 - Coesão;
A definição de **coesão** diz que é algo onde há harmônia na junção de duas coisas. Partindo desta definição, na Orientação à Objetos uma classe coesa é aquela que contém somente membros que tenham algo em comum, dado o contexto da própria classe. Os atributos e métodos devem ser condizentes com o contexto de definição da classe. As classes que não estão de acordo com esse pensamento, tendem a crescer indefinidamente, perdendo a razão de existir, as tornando difíceis de manter.

 - Encapsulamento;
A definição de **encapsulamento** diz que é o ato de incluir, ou proteger algo do mundo externo.  Na Orientação à Objetos, esse processo é feito tornando os membros ou a implementação de algo não exposta a outras classes do sistema; é uma blindagem que torna o código mais fácil de alterar suas estruturas internas, pois sua API publica não o expõe. Portanto, os atributos podem ser validados contra valores incorretos quando tiverem que ser alterados. Nem sempre autilização de atributos privados conjutamente com um getter e setter é considerado uma boa prática, pois a geração dos métodos setter podem gerar falhas no encapsulamento da classe. Classes não encapsuladas permitem violações de regras de negócio.

 - Acoplamento;
A definição de **acoplamento** é expressa como: ação de acoplar, agrupamento em pares. Na Orientação à Objetos, o **acoplamento** diz respeito ao relacionamento de dependência entre duas classes. Este conceito é inerente à OO, mas o que o torna um aspecto ruim é quando há um algo grau de dependência entre os relacionamento, fazendo com que uma alteração em um elo do relacionamento cause efeitos colaterais no outro lado. O encapsulamento de comportamento está diretamento relacionado com o acoplamento entre classes, pois um algoritmo, ao invés de estar encapsulado em uma classe está disperso por todo o código, fazendo com que uma mudança na lógica quebre os outros algoritmos. Classes acopladas causam fragilidade no código da aplicação, o que dificulta sua manutenção.


### Single Responsibility Principle (SRP) - Princípio da Responsabilidade Única
Segundo Robert C. Martin (também conhecido como, Uncle Bob), "Uma classe deveria ter apenas um único motivo para mudar". O que esta frase quer dizer é que, uma classe que tem uma única responsabilidade tem uma interface desacoplada, e que portanto, somente deveria ser alterada quando algo que está diretamente relacionado com sua razão de existir mudar. Um exemplo de uma classe que não tem essa qualificação, são classes que tem diversos métodos que executam operações que não dizem respeito a seu contexto. No exemplo deste projeto, uma refatoração - com a técnica de **Extract Method** - foi feita para que a classe **Funcionario** não estivesse a par do algoritmo de cálculo de reajuste de salário. Dessa forma, uma outra classe foi criada para desempenhar essa tarefa, a classe **ReajusteService**. Este princípio está intimamente ligado com o nível de coesão de uma classe, pois quanto mais coesa uma classe é, menos responsabilidades ela tem.

### Open Closed Principle (OCP) - Princípio Aberto Fechado
Segundo Bertrand Meyer, "Entidades de software (classes, módulos, funções, etc) devem estar abertas para extensão, porém fechadas para modificação". No exemplo deste projeto, a classe **ReajusteService** está ganhando mais uma regra de negócio relacionada a uma nova verificação quanto a validade de se poder conceder um reajuste de salário a um funcionário. Um questionamento que deve ser feito é... será que ela deve ficar sendo alterada constantemente com novas regras de negócio? Neste caso a resposta é, não. Portanto, foi feito a separação das validações em classes com essa responsabilidade. A classe **ReajusteService** agora, recebe por *injeção de dependência* através do construtor todas as validações que forem necessárias e, no método de calcular o reajuste cada validação vai ser chamada. O que vale ressaltar é que a classe **ReajusteService** não mais está fadada a ficar sendo alterada constantemente toda vez que houver uma nova regra de negócio, assim se tornando uma classe que está seguindo o princípio do *Aberto Fechado*, conforme citado na primeira linha deste parágrafo.

### Liskov Substitution Principle (LSP) - Princípio da Substituição de Liskov

### Interface Segregation Principle - Princípio da Segregação de Interfaces

### Dependency Inversion Principle - Princípio da Inversão de Dependência
