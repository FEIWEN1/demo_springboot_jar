package com.dingzhi.demo_springboot_jar.stateMachine.setcodes;

import com.dingzhi.demo_springboot_jar.stateMachine.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author feiwen
 * @date 2024/3/5
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntranceMachineTransaction {
    private EntranceMachineState currentState;

    private Action action;

    private EntranceMachineState nextState;

    private Event event;
}
