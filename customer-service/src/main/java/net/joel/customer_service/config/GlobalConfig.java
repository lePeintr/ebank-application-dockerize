package net.joel.customer_service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix="global.params") //Au demarage de l'application,il va creer un objet globalConfig
//dont p1=global.params.p1 et p2=global.params.p2
@RefreshScope
//record est un bean immutablet il n'a pas de setter c'est pour ca que le refresh ne marche pas
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig{
    int p1;
    int p2;
}
