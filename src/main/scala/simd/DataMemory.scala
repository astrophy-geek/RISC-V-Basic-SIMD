package simd

import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile

class DataMemory(memSize: Int) extends Module {
  val io = IO(new Bundle {
    val addr = Input(Vec(8, UInt(32.W)))     // Addresses for 8 lanes
    val dataIn = Input(Vec(8, SInt(32.W)))  // Data to write for 8 lanes
    val wen = Input(Bool())                  // Write enable
    val ren = Input(Bool())                  // Read enable
    val dataOut = Output(Vec(8, SInt(32.W)))// Data read from 8 lanes
  })

  val mem = Mem(memSize, SInt(32.W))

  loadMemoryFromFile(mem, "./src/main/resources/data.hex")

  // printf("Memory contents after loading:\n")
  // for (i <- 0 until 26) {
  //   printf("%d: %x\n", i.U, mem.read(i.U, true.B))
  // }


  val dataOutVec = Wire(Vec(8, SInt(32.W)))
  
  when(io.wen) {
    for (i <- 0 until 8) {
      mem.write(io.addr(i), io.dataIn(i))
      printf("Writing to address %d = %d\n", io.addr(i), io.dataIn(i))
    }
    dataOutVec := VecInit(Seq.fill(8)(0.S))
  } .elsewhen(io.ren) {
    for (i <- 0 until 8) {
      dataOutVec(i) := mem.read(io.addr(i)) // Enable read port
    }
    for (i <- 0 until 8) {
      printf("Reading from address %d = %d\n", io.addr(i), dataOutVec(i))
    }
  } .otherwise {
    dataOutVec := VecInit(Seq.fill(8)(0.S))
  }

  io.dataOut := dataOutVec
}