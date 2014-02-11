package com.lyncode.xoai.dataprovider.repository;

import com.lyncode.xoai.dataprovider.handlers.results.ListSetsResult;
import com.lyncode.xoai.dataprovider.model.Set;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class InMemorySetRepository implements SetRepository {
    private boolean supportSets = true;
    private List<Set> sets = new ArrayList<Set>();

    public InMemorySetRepository doesNotSupportSets() {
        this.supportSets = false;
        return this;
    }

    public InMemorySetRepository withSet(String name, String spec) {
        this.sets.add(new Set(spec).withName(name));
        return this;
    }

    public InMemorySetRepository withRandomSets(int number) {
        for (int i = 0; i < number; i++) {
            this.sets.add(new Set(randomAlphabetic(number)).withName("Set" + (i + 1)));
        }
        return this;
    }

    @Override
    public boolean supportSets() {
        return supportSets;
    }

    @Override
    public ListSetsResult retrieveSets(int offset, int length) {
        return new ListSetsResult(offset + length < this.sets.size(), this.sets.subList(offset, Math.min(offset + length, sets.size())));
    }

    @Override
    public boolean exists(String setSpec) {
        for (Set s : this.sets)
            if (s.getSpec().equals(setSpec))
                return true;

        return false;
    }
}
