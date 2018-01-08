import React, { Component } from 'react';
import { Container, Header, Form, Button, Dropdown, Input, TextArea } from 'semantic-ui-react';
// private int id;
// private String isbn;
// private String title;
// private List<Author> authors = new ArrayList<>();
// private Publisher publisher;
// private int year;
// private int count;
// private int size;
// private String description;
// private Date addedAt;
class CreateBook extends Component {
  constructor() {
    super();
    this.state = {
      book: {
        title: '',
        authors: [],
        publisher: '',
        year: '',
        count: '',
        size: '',
        description: '',
      },
    };
  }

  render() {
    const authors = [
      { key: 'angular', text: 'Angular', value: 'angular' },
      { key: 'css', text: 'CSS', value: 'css' },
      { key: 'design', text: 'Graphic Design', value: 'design' },
      { key: 'ember', text: 'Ember', value: 'ember' },
      { key: 'html', text: 'HTML', value: 'html' },
      { key: 'ia', text: 'Information Architecture', value: 'ia' },
      { key: 'javascript', text: 'Javascript', value: 'javascript' },
      { key: 'mech', text: 'Mechanical Engineering', value: 'mech' },
      { key: 'meteor', text: 'Meteor', value: 'meteor' },
      { key: 'node', text: 'NodeJS', value: 'node' },
      { key: 'plumbing', text: 'Plumbing', value: 'plumbing' },
      { key: 'python', text: 'Python', value: 'python' },
      { key: 'rails', text: 'Rails', value: 'rails' },
      { key: 'react', text: 'React', value: 'react' },
      { key: 'repair', text: 'Kitchen Repair', value: 'repair' },
      { key: 'ruby', text: 'Ruby', value: 'ruby' },
      { key: 'ui', text: 'UI Design', value: 'ui' },
      { key: 'ux', text: 'User Experience', value: 'ux' },
    ];
    const {
      title, publisher, year, count, size, description,
    } = this.state;
    return (
      <Container text>
        <Header>Добавить книгу</Header>
        <Form>
          <Form.Field>
            <label>Название</label>
            <input value={title} placeholder="Название книги" />
          </Form.Field>
          <Form.Field>
            <label>Выбрать авторов книги</label>
            <Dropdown placeholder="Выбрать авторов" fluid multiple selection options={authors} />
          </Form.Field>
          <Form.Field>
            <label>Выбрать издательство</label>
            <input title={publisher} placeholder="Название книги" />
          </Form.Field>
          <Form.Field>
            <label>Введите год издания</label>
            <input title={year} placeholder="Год издания" />
          </Form.Field>
          <Form.Field>
            <label>Колличество книг на складе</label>
            <input title={count} placeholder="Колличество книг на складе" />
          </Form.Field>
          <Form.Field>
            <label>Колличество книг на складе</label>
            <Input
              value={size}
              label={{ basic: true, content: 'страниц' }}
              labelPosition="right"
              placeholder="Введите колличество страниц в книге"
            />
          </Form.Field>
          <Form.Field>
            <label>Описание книги</label>
            <TextArea value={description} placeholder="Tell us more" style={{ minHeight: 100 }} />
          </Form.Field>
          <Button type="submit">Submit</Button>
        </Form>
      </Container>
    );
  }
}

export default CreateBook;
