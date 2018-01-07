import express from 'express';
import cors from 'cors';
import data from './data.json';

const app = express();

app.get('/', cors(), (req, res) => {
  res.json({ data });
});

app.get('/getBook/:id', cors(), (req, res) => {
  const { id } = req.params;
  const resultBook = data.list.filter(book => book.id === id);
  res.json({ data: resultBook });
});

app.listen(3004);
