package com.yanyi.designpattern.strategy;

/**
 * Context上下文对象，持有一个策略对象，供客户端调用
 * @author chenqiang
 * @since 2021-01-28 14:36
 */
public class Price {

    private Strategy strategyContext;

    /**
     * 根据会员等级调用具体策略计算出折扣价格
     * @param price 原价
     * @return 折扣价格
     */
    public double quote(double price, Integer level) {
        this.strategyContext = checkMemberLevel(level);
        return strategyContext.caclPrice(price);
    }

    /**
     * 无会员等级
     * @param price 原价
     * @return 折扣价格
     */
    public double quote(double price) {
        this.strategyContext = checkMemberLevel(0);
        return strategyContext.caclPrice(price);
    }

    /**
     * 根据会员等级获取具体的策略对象
     * @param level
     * @return
     */
    private Strategy checkMemberLevel(int level) {
        Strategy strategy;
        switch (level) {
            case 1:
                strategy = new PrimaryMemberStratehy();
                break;
            case 2:
                strategy = new IntermediateMemberStrategy();
                break;
            case 3:
                strategy = new AdvanceMemberStrategy();
                break;
            default:
                strategy = price -> price;
                break;
        }
        return strategy;
    }
}
