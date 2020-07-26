package com.deliveryit.challenge.thiago.domain;

import com.deliveryit.challenge.thiago.domain.fines.CriticalFine;
import com.deliveryit.challenge.thiago.domain.fines.EarlyFine;
import com.deliveryit.challenge.thiago.domain.fines.MediumFine;
import com.deliveryit.challenge.thiago.domain.fines.NoFine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FineService {

    private List<Fine> fines = new ArrayList<>();
    private final Fine noFine = new NoFine();

    @PostConstruct
    private void buildFineList() {
        fines.add(new EarlyFine());
        fines.add(new MediumFine());
        fines.add(new CriticalFine());
    }

    public Fine locate(Integer daysOverdue) {
        return fines.stream()
                .filter(fine -> fine.accept(daysOverdue))
                .findFirst()
                .orElse(noFine);
    }

}