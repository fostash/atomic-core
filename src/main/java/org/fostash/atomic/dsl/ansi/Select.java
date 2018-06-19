package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IRepresentable;

import java.util.Arrays;

public class Select implements IRepresentable {

    private IExpression<?>[] selectList;

    Select() {
        this.selectList = null;
    }

    Select(IExpression<?>[] selectList) {
        if (selectList.length > 0) {
            this.selectList = Arrays.copyOf(selectList, selectList.length);
        } else {
            this.selectList = null;
        }
    }

    public IExpression<?>[] getSelectList() {
        return selectList;
    }

    @Override
    public String getRepresentation() {
        if (this.selectList == null) {
            return "SELECT *";
        }

        final StringBuilder statementPart = new StringBuilder();
        for (final IExpression<?> expr : this.selectList) {
            if (statementPart.length() == 0) {
                statementPart.append("SELECT ");
            } else {
                statementPart.append(", ");
            }

            statementPart.append(expr.getRepresentation());
        }

        return statementPart.toString();
    }
}
