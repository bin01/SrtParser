grammar Srt;

@header {
  package com.bin01.srt; 
}

parse
:
  LineBreak* blocks LineBreak* EOF
;

blocks
:
  block
  (
    LineBreak LineBreak+ block
  )*
;

block
:
  Number Spaces? LineBreak timeRange LineBreak textLines
;

timeRange
:
  Time Spaces? Arrow Spaces? Time Spaces?
;

textLines
:
  line
  (
    LineBreak line
  )*
;

line
:
  Spaces? word
  (
    Spaces word
  )* Spaces?
;

word
:
  (
    Other
    | Number
    | Dashes
    | Arrow
  )+ 
;

Time
:
  Number ':' Number ':' Number ',' Number
;

Arrow
:
  '-->'
;

Dashes
:
  '-'+
;

Number
:
  '0' .. '9'+
;

LineBreak
:
  '\r'? '\n'
  | '\r'
;

Spaces
:
  (
    ' '
    | '\t'
  )+
;

Other
:
  .
;