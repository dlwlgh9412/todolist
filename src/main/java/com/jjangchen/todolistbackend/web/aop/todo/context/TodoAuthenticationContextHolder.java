package com.jjangchen.todolistbackend.web.aop.todo.context;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TodoAuthenticationContextHolder {
    private static TodoAuthenticationContextStrategyList strategyName;
    private static TodoAuthenticationContextHolderStrategy strategy;

    static {
        initialize();
    }

    public static void initialize() {
        if(strategyName == null) {
            strategyName = TodoAuthenticationContextStrategyList.DEFAULT;
        }

        if(strategyName == TodoAuthenticationContextStrategyList.DEFAULT) {
            strategy = new TodoThreadLocalAuthenticationContextHolderStrategy();
            return;
        }
    }

    public static void clearContext() {
        strategy.clearContext();
    }

    public static TodoAuthenticationContext getContext() {
        return strategy.getContext();
    }

    public static void setContext(TodoAuthenticationContext context) {
        strategy.setContext(context);
    }

    protected static TodoAuthenticationContext createEmptyContext() {
        return strategy.createEmptyContext();
    }
}
