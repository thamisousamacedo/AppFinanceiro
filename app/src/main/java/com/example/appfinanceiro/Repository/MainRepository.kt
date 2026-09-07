package com.example.appfinanceiro.Repository

import com.example.appfinanceiro.Domain.BudgetDomain
import com.example.appfinanceiro.Domain.ExpenseDomain

class MainRepository {
    val items = mutableListOf(
        ExpenseDomain("Restaurante",573.12,"resturant","17 aug 2026 19:15"),
        ExpenseDomain("McDonald's",77.82,"mcdonald","16 aug 2026 13:57"),
        ExpenseDomain("Cinema",23.47,"cinema","16 aug 2026 20:45"),
        ExpenseDomain("Restaurante",573.12,"resturant","15 aug 2025 22:18")
    )
    val budget = mutableListOf(
        BudgetDomain("Financiamento da Casa", 1200.0, 80.8),
        BudgetDomain("Assinatura",550.0,10.0),
        BudgetDomain("Financiamento do Carro",800.0,30.0),
    )
}