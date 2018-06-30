package com.example.coloredlists.utils.validators;

import com.example.coloredlists.models.Item;
import com.example.coloredlists.utils.validators.base.Validator;


public class ItemValidator implements Validator<Item> {
        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 150;

        @Override
        public boolean isValid(Item item) {
            return item != null &&
                    isLengthValid(item.getText());
        }

        private boolean isLengthValid(String note) {
            return note != null &&
                    note.length() >= MIN_LENGTH&&
                    note.length() <= MAX_LENGTH;
        }
    }

