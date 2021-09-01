package by.alex.task04.controller.command;

import by.alex.task04.controller.command.impl.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<CommandName, Command> COMMAND_MAP = initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {
        return Map.ofEntries(
                Map.entry(CommandName.CALCULATE_ACCOUNTS_BALANCE, new CalculateAccountBalance()),
                Map.entry(CommandName.CALCULATE_ACTIVE_ACCOUNT_BALANCE, new CalculateActiveAccountBalance()),
                Map.entry(CommandName.CALCULATE_BLOCKED_ACCOUNT_BALANCE, new CalculateBlockedAccountBalance()),
                Map.entry(CommandName.CHANGE_ACCOUNT_STATUS, new ChangeAccountStatusCommand()),
                Map.entry(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand()),
                Map.entry(CommandName.FIND_ACCOUNT_BY_BALANCE, new FindAccountByBalanceCommand()),
                Map.entry(CommandName.FIND_ACCOUNT_BY_NUMBER, new FindAccountByNumberCommand()),
                Map.entry(CommandName.SORT_ACCOUNT_BY_BALANCE_ASC, new SortAccountByBalanceASC()),
                Map.entry(CommandName.SORT_ACCOUNT_BY_BALANCE_DESC, new SortAccountByBalanceDESC()),
                Map.entry(CommandName.NO_SUCH_COMMAND, new NoSuchCommandCommand())
        );
    }

    public Command getCommand(CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new NoSuchCommandCommand());
    }

}
