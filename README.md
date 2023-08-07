# TI-Investimentos
Projeto para entrevista TI Investimentos

# Geral

# Dependências
- Docker
- Maven

# Instalação

- inicie os containers com #docker-compose up
- inicie a aplicação dentro de cada modulo com #mvn spring-boot:run

## Git

O desenvolvimento deste projeto deve seguir uma simplificação do Git Flow:

- **Commits diretos** nas branchs **develop**, **homolog** e **main** são **bloqueados** devido a execução da pipeline de build nessas branchs. Portanto, **antes de desenvolver verifique se você não está em nenhuma dessas branchs.**

- **Todas as features/patchs** precisam ser desenvolvidas em **branch separadas** que devem ser criadas a partir da **develop**. Por exemplo, o nome de uma branch que está desenvolvendo da funcionalidade order seria: `feature/order`.

- **Teste** o **seu código**. Não faça PRs sem testar os possíveis cenários e comportamentos!

- **Ao término de uma feature/patch** abra um **pull request** da sua branch para a **develop**. **Abra pull requests frequentemente** para **evitar** abrir um **único PR com milhares de linhas de código-fonte modificadas**. E o mais **importante, antes de abrir um PR puxe as últimas alterações da develop na sua branch e garanta que as suas modificações funcionam com a versão mais recente da develop.**

