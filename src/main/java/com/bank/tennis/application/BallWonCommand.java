package com.bank.tennis.application;

import com.bank.tennis.domain.Player;

/**
 * Event that a player won the ball
 * @param winner
 */
public record BallWonCommand(Player winner) {
}
