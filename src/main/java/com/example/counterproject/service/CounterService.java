package com.example.counterproject.service;

import com.example.counterproject.domain.Counter;
import com.example.counterproject.repository.CounterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class CounterService {
    private final CounterRepository counterRepository;
    public String getNextCode(String currentCode) {
        String nextCode = getNextCodeValue(currentCode);
        saveNextCode(nextCode);
        return nextCode;
    }

    private String getNextCodeValue(String currentCode) {
        if (currentCode == null) {
            return "a0a0";
        }
        int length = currentCode.length();
        char[] chars = currentCode.toCharArray();
        int index = length - 1;
        while (index >= 0 && chars[index] == '9') {
            chars[index] = 'a';
            index--;
        }
        if (index < 0) {
            char[] newChars = new char[length + 1];
            Arrays.fill(newChars, 'a');
            return new String(newChars);
        }
        chars[index]++;
        return new String(chars);
    }

    private void saveNextCode(String nextCode) {
        Counter counter = counterRepository.findById(1L).orElse(new Counter("a0a0"));
        counter.setValue(nextCode);
        counterRepository.save(counter);
    }
}
