#!/usr/bin/env bash
set -euo pipefail

echo "[INFO] Validating Java and Maven..."
java -version
mvn -version

echo "[INFO] Cleaning and resolving dependencies..."
mvn -q -DskipTests clean compile

echo "[INFO] Generating Eclipse project metadata..."
mvn -q eclipse:clean eclipse:eclipse

echo "[INFO] Done. Import generated project in Eclipse as Existing Project."
