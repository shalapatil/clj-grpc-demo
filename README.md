# clj-grpc-demo

Demonstrates how to use GRPC with clojure. Implements basic calculator with only add & subtract function.

## Installation

- Need java8

## Usage

Project is using lein-protoc plugin which is used to create java client stubs.


clj-grpc-demo.server> (-main)

clj-grpc-demo.server> (require 'clj-grpc-demo.client)

clj-grpc-demo.server> (clj-grpc-demo.client/add 1 1)
=> 2
