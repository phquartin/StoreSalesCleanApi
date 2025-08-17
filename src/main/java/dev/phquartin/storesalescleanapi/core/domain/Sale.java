package dev.phquartin.storesalescleanapi.core.domain;

import dev.phquartin.storesalescleanapi.core.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private Long id;
    private List<SaleItens> itens;
    private LocalDateTime dateTime;
    private Double totalValue;
    private PaymentMethod paymentMethod;

    public Sale(Long id, List<SaleItens> itens, LocalDateTime dateTime, PaymentMethod paymentMethod) {
        this.id = id;
        this.itens = itens;
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
        this.totalValue = calculateTotalValue();
    }

    private Double calculateTotalValue() {
        return this.itens.stream().mapToDouble(SaleItens::getPrice).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItens> getItens() {
        return itens;
    }

    public void setItens(List<SaleItens> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
