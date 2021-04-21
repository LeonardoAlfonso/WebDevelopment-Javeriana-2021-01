package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Commands;

import com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ.RabbitMqDomainEventsConsumer;

public class TestCommand implements ConsoleCommand {

    private RabbitMqDomainEventsConsumer consumer;

    public TestCommand(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute() {
//        while(true) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Soy la perra Test Command");
//        }
        consumer.consume();
    }
}
