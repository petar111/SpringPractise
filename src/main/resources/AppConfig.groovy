
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.springteam.springpractise.main.Main
import com.springteam.springpractise.service.impl.SpringWelcomeServiceSimple
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.springteam.springpractise.groovy.rule.engine.impl",
                               "com.springteam.springpractise.groovy.rule.factory.impl",
                               "com.springteam.springpractise.groovy.rule.service.impl"])
class MyApplicationConfiguration{
    
}

beans{
    simpleService(SpringWelcomeServiceSimple)
    main(Main, ref('simpleService'), "MAIN_LABEL")
}

