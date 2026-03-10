# Opportunistic Network Simulator

A simple Java simulator for Delay Tolerant Networks (DTN).

## Description

This project simulates an opportunistic network where mobile nodes move in a 2D space and exchange messages when they come within communication range.

The simulator implements a basic **Epidemic Routing** strategy.

## Features

- Random node mobility
- Contact detection between nodes
- Message propagation using epidemic routing
- Message delivery detection

## Project Structure

src/simulator

Node.java        -> represents a network node  
Message.java     -> represents a message  
Simulator.java   -> simulation engine  
Routing.java     -> routing logic  
Main.java        -> program entry point

## How to Run

Compile and run:
