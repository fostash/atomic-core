package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.ansi.expressions.functions.LowerCase;
import org.fostash.atomic.dsl.ansi.expressions.functions.UpperCase;

public interface ISqlFunction extends IExpression {

    default LowerCase toLowerCase() {
        return new LowerCase(this);
    }

    default UpperCase toUpperCase() {
        return new UpperCase(this);
    }
}
