# ovoid-world

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg?style=flat-square)](#)
[![Java Version](https://img.shields.io/badge/java-17%2B-blue.svg?style=flat-square)](#)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

Internal dev space for the *Spyro: Year of the Dragon* save editor and binary manipulation toolchain.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Supported Systems](#supported-systems)
3. [Language & Tech Stack](#language--tech-stack)
4. [Features](#features)
5. [Architecture & Data Model](#architecture--data-model)
6. [Installation & Setup](#installation--setup)
7. [API & CLI Usage](#api--cli-usage)
8. [Master TODO List](#master-todo-list)
9. [Contributing](#contributing)
10. [Credits & References](#credits--references)

---

## Introduction

**ovoid-world** is a save file editor and binary utility suite designed for parsing, modifying, and rebuilding PlayStation (*Spyro: Year of the Dragon*) memory card slot data. It provides zero-overhead binary data mapping, dynamic checksum recalculation, and a planned graphical interface to inspect and modify game progress safely.

**Key Goals:**
* 1:1 mapping of memory card save slots (`SaveSlot`).
* Robust validation and auto-recalculation of checksums (`SaveTools`).
* Inspection and modification of inventory, level completion flags, minigame high scores, and ACT difficulty tables.

---

## Supported Systems

Work in progress...

---

## Language & Tech Stack

* **Java (17+):** Chosen for optimal cross-platform portability, structured memory access via byte buffers, and reliable GUI integration.
* **UI Framework:** Standard Swing / JavaFX component architecture for a native cross-platform layout.
* **Architecture:** Static nested structures for 1:1 data representation, decoupled low-level bitwise tools.

---

## Features

### Active Features
* **Byte Array Save File Verification:** Validates incoming save file sizes against expected memory card slot bounds.
* **Endian-Aware Binary Reading:** Custom buffer parsing for Little-Endian integer conversion.
* **Checksum Computation:** Algorithmic calculation of slot verification sums.

### Planned Features
* **Automatic Checksum Recalculation:** Recomputes and writes new checksums automatically during save operations.
* **Automatic Format Detection:** Detects memory card headers vs. single save slot dumps.
* **Cross-Format Conversion:** Convert between raw memory card dumps (`.mcd`/`.gme`) and slot saves (`.BAC0`).
* **Side-by-Side Hex Highlighting & Syncing:** Real-time hex editor tied to GUI fields.
* **Snapshot & Backup Manager:** Automatic revision history to prevent save corruption.
* **Save Diff & Comparison Tool:** Compare two save states field-by-field.
* **Boring Mode & CLI Mode:** Headless execution mode for batch editing.
* **Patch Generation:** Export targeted diff patches for save modding.

---

## Architecture & Data Model

The application represents save data as a single monolithic object mirroring the original memory card data layout:

* **Data Holder Structure (`SaveSlot`):** Represents low-level native game memory (Progress Flags, Moneybags Data, Gem Tolls, Skill Points, Minigame Records).
* **Utility Layer (`SaveTools`):** Manages file I/O operations, endianness conversions, and checksum validations.
* **Main Entry (`Main`):** Primary launcher and GUI orchestrator.

---

## Installation & Setup

Work in progress...

---

## API & CLI Usage

Work in progress...

---

## Master TODO List

Below is the aggregate list of pending tasks and features collected across the project source files and roadmap:

### ⚙️ Core Logic & Serialization (`SaveSlot.java` / `SaveTools.java`)
- [ ] Implement complete binary field parsing in `SaveSlot.parseByteArray(byte[] data)`.
- [ ] Add a default constructor to `SaveSlot`.
- [ ] Add a constructor to `SaveSlot` accepting `byte[]` that invokes `parseByteArray()`.
- [ ] Add `setChecksum()` implementation to compute and assign slot checksums.
- [ ] Implement `toByteArray()` serialization function to write all fields back into raw binary layout.

### 🖥️ User Interface & Lifecycle (`Main.java`)
- [ ] Initialize and launch the main GUI window in `Main.main()`.
- [ ] Build tabbed GUI layout for game sections (Inventory, Level Flags, Minigames, ACT).
- [ ] Build side-by-side live hex view and syncing side panel.

### 📖 Documentation & Setup
- [ ] Complete [Supported Systems](#supported-systems) documentation.
- [ ] Complete [Installation & Setup](#installation--setup) guide.
- [ ] Complete [API & CLI Usage](#api--cli-usage) reference.

---

## Contributing

Work in progress...

---

## Credits & References

* Reverse engineering data adapted from the **Spyro: Year of the Dragon** decompile project.
* Visit the decompile repository on [GitHub](https://github.com/TheMobyCollective/spyro-3).
* Special thanks to **The Moby Collective** for their work on the Spyro decompilation efforts!
* GPLV3 LICENSE.md copied from the **Markdown Licenses** [GitHub repository](https://github.com/IQAndreas/markdown-licenses/).
* Special thanks to **IQAndreas** and the **[Free Software Foundation](https://www.fsf.org/)**
