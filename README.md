# Nuclear Reactor Simulation Core 🚀☢️  

**Simulação de Reator de Fissão Nuclear com Spring Boot e Kotlin**  

![Java](https://img.shields.io/badge/Java-17-orange)
![SpringBoot](https://img.shields.io/badge/Spring%20Boot-3.1-blue)
![Android](https://img.shields.io/badge/Android-Kotlin-green)

Um projeto de simulação de reator nuclear modular, desenvolvido em 3 etapas:  
1. **Núcleo de Simulação**: Modelagem física de fissão, equilíbrio térmico e controle de reações.  
2. **Aplicativo Android**: Monitoramento em tempo real com gráficos interativos.  
3. **Cloud Deployment**: Escalabilidade em nuvem com Docker e Kubernetes.  

## ⚙️ Funcionalidades Atuais  
- Cálculo de fluxo de nêutrons e temperatura crítica  
- Simulação de eventos aleatórios (ex: superaquecimento)  
- API REST para controle do reator  
- Banco de dados de elementos químicos (PostgreSQL)  

## 🛠️ Tecnologias  
- **Backend**: Java 21, Spring Boot 3.1, Hibernate  
- **Mobile**: Kotlin, Retrofit, MPAndroidChart (Etapa 2)  
- **Infra**: Docker, AWS ECS, PostgreSQL (Etapa 3)  

## 🚀 Como Executar  
```bash  
git clone https://github.com/ThiagoST32/nuclear-reactor-simulator.git
cd nuclear-reactor-simulator  
docker-compose up -d  # Inicia PostgreSQL  
./mvnw spring-boot:run  
