package com.jjangchen.todolistbackend.web.aop.authentication.context;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class TodoThreadLocalAuthenticationContextHolderStrategy implements  TodoAuthenticationContextHolderStrategy{
    private ThreadLocal<TodoAuthenticationContext> context = new ThreadLocal<>();

    @Override
    public void clearContext() {
        this.context.remove();
    }

    @Override
    public TodoAuthenticationContext getContext() {
        TodoAuthenticationContext ctx = this.context.get();
        if(ctx == null) {
            ctx = createEmptyContext();
            this.context.set(ctx);
        }

        return ctx;
    }

    @Override
    public void setContext(TodoAuthenticationContext context) {
        Assert.notNull(context, "인증컨텍스트는 null이 될 수 없습니다.");
        this.context.set(context);
    }

    @Override
    public TodoAuthenticationContext createEmptyContext() {
        return new TodoAuthenticationContextImpl();
    }
}
